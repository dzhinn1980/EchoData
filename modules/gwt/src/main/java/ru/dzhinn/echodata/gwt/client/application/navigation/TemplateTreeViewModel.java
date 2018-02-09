package ru.dzhinn.echodata.gwt.client.application.navigation;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;
import com.google.inject.Inject;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import ru.dzhinn.echodata.gwt.client.application.navigation.model.TemplateTreeModel;
import ru.dzhinn.echodata.gwt.shared.dispatch.template.GetChildTemplateListAction;
import ru.dzhinn.echodata.gwt.shared.dispatch.template.GetChildTemplateListResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A.Dzhioev on 11.01.2018.
 */
public class TemplateTreeViewModel implements TreeViewModel{

    @Inject
    private DispatchAsync dispatch;

    List<TemplateTreeModel> highLevelTemplateList = new ArrayList<>();

    public TemplateTreeViewModel(List<TemplateTreeModel> highLevelTemplateList) {
        this.highLevelTemplateList = highLevelTemplateList;
    }

//    private List<TemplateTreeModel> getChildTemplateListAction(Long parentId){
//        List<TemplateTreeModel> result = new ArrayList<>();
//        dispatch.execute(new GetChildTemplateListAction(parentId), new AsyncCallback<GetChildTemplateListResult>() {
//            @Override
//            public void onFailure(Throwable caught) {
//                Window.alert("hyi");
//                result ;
//            }
//
//            @Override
//            public void onSuccess(GetChildTemplateListResult result) {
//                getView().setPatientList(result.getModels());
//            }
//        });
//    }

    private static class CategoryCell extends AbstractCell<TemplateTreeModel> {

        /**
         * The html of the image used for contacts.
         */
//        private final String imageHtml;

        public CategoryCell() {
        }

        @Override
        public void render(Context context, TemplateTreeModel value, SafeHtmlBuilder sb) {
            if (value != null) {
                sb.appendEscaped(value.getName());
            }
        }
    }


    @Override
    public <T> NodeInfo<?> getNodeInfo(T value) {

        ListDataProvider<TemplateTreeModel> dataProvider = new ListDataProvider<>();

        if (value == null){
//            for (int i = 0; i < 2; i++) {
//                dataProvider.getList().add("Top level item : " + (i + 1));
//            }
            dataProvider.getList().addAll(highLevelTemplateList);
        } else {
//            for (int i = 0; i < 2; i++) {
//                dataProvider.getList().add(value + "." + String.valueOf(i));
//            }
        }


        return new DefaultNodeInfo<TemplateTreeModel>(dataProvider, new CategoryCell());
    }

    @Override
    public boolean isLeaf(Object value) {
        if (value == null) return false;

        if (String.valueOf(value).contains("0")) return true;
        return (value.toString().length() > 30);
    }
}
