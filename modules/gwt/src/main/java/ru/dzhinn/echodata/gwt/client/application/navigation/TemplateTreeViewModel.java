package ru.dzhinn.echodata.gwt.client.application.navigation;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.*;
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

    List<TemplateTreeModel> highLevelTemplateList;
    SingleSelectionModel<TemplateTreeModel> templateSelectionModel;

//    private final DefaultSelectionEventManager<TemplateTreeModel> selectionManager =
//            DefaultSelectionEventManager.createDefaultManager();



    public TemplateTreeViewModel(List<TemplateTreeModel> highLevelTemplateList, SingleSelectionModel<TemplateTreeModel> templateSelectionModel) {
        this.highLevelTemplateList = highLevelTemplateList;
        this.templateSelectionModel = templateSelectionModel;
    }

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
                if (((TemplateTreeModel)value).isFolder()){
                    sb.appendHtmlConstant("<b>");
                    sb.appendEscaped(value.getName());
                    sb.appendHtmlConstant("</b>");
                } else {
                    sb.appendEscaped(value.getName());
                }
            }
        }
    }


    @Override
    public <T> NodeInfo<?> getNodeInfo(T value) {

        ListDataProvider<TemplateTreeModel> dataProvider = new ListDataProvider<>();

        if (value == null){
            dataProvider.getList().addAll(highLevelTemplateList);
        } else {
        }

//        return new DefaultNodeInfo<TemplateTreeModel>(dataProvider, new CategoryCell());

        return new DefaultNodeInfo<TemplateTreeModel>(dataProvider, new CategoryCell(), templateSelectionModel, null);
    }

    @Override
    public boolean isLeaf(Object value) {
        if (value == null) return false;

        if (((TemplateTreeModel)value).isFolder()) return false;

        return true;
    }
}
