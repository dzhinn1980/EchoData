package ru.dzhinn.echodata.gwt.client.application.navigation;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;
import ru.dzhinn.echodata.gwt.client.application.navigation.model.TemplateTreeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A.Dzhioev on 11.01.2018.
 */
public class TemplateViewModel implements TreeViewModel{

    List<TemplateTreeModel> templateList;

    final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();



    TemplateViewModel() {
//        TemplateTreeModel head = new TemplateTreeModel("Head");
//
//        head.setChild(new ArrayList<TemplateTreeModel>());
//
//        for (int i = 0; i < 7; i++){
//            head.getChild().add(new TemplateTreeModel("First Level Element №" + (i + 1)));
//        }
//
//        templateList.add(head);
    }

    public TemplateViewModel(List<TemplateTreeModel> templateList) {
        this.templateList = templateList;
    }

    @Override
    public <T> NodeInfo<?> getNodeInfo(T value) {
//        if (value == null){
//            ListDataProvider<TemplateTreeModel> dataProvider
//                    = new ListDataProvider<>(
//                    templateList);
//
//            // Create a cell to display a composer.
//            Cell<TemplateTreeModel> cell
//                    = new AbstractCell<TemplateTreeModel>() {
//                @Override
//                public void render(Context context, TemplateTreeModel value, SafeHtmlBuilder sb) {
//                    if (value != null) {
//                        sb.appendHtmlConstant("    ");
//                        sb.appendEscaped(value.getName());
//                    }
//                }
//            };
//
//            // Return a node info that pairs the data provider and the cell.
//            return new DefaultNodeInfo<TemplateTreeModel>(dataProvider, cell);
//        } else
            if (value instanceof TemplateTreeModel){
//            ListDataProvider<TemplateTreeModel> dataProvider;
            if (((TemplateTreeModel) value).getChild() != null){
                ListDataProvider<TemplateTreeModel> dataProvider = new ListDataProvider<>(((TemplateTreeModel) value).getChild());
                return new DefaultNodeInfo(dataProvider, new TextCell(), selectionModel, null);
            }
//            else {
//                ListDataProvider<String> dataProvider = new ListDataProvider<String>(((TemplateTreeModel) value).getName());
//                return new DefaultNodeInfo(dataProvider, new TextCell(), selectionModel, null);
//            }


        }

        return null;
    }

    @Override
    public boolean isLeaf(Object value) {
        return false;
    }
}
