package ru.dzhinn.echodata.web.gwt.client.widget.navigation;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import ru.dzhinn.echodata.web.gwt.client.resources.AppResources;
import ru.dzhinn.echodata.web.gwt.client.widget.navigation.render.ContactCell;
import ru.dzhinn.echodata.web.gwt.client.widget.navigation.render.ContactInfo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by A.Dzhioev on 06.02.2017.
 */
public class EchoDataNavigation extends Composite {
    interface Binder extends UiBinder<StackLayoutPanel, EchoDataNavigation> { }
    private static final Binder binder = GWT.create(Binder.class);

    @UiField
    ScrollPanel patientListPanel;

    private static final List<ContactInfo> Contacts = Arrays.asList(
            new ContactInfo("fio1", "adr1"),
            new ContactInfo("fio2", "adr2"),
            new ContactInfo("fio3", "adr3"),
            new ContactInfo("fio4", "adr4"),
            new ContactInfo("fio5", "adr5"),
            new ContactInfo("fio6", "adr6"),
            new ContactInfo("fio7", "adr7"),
            new ContactInfo("fio8", "adr8"),
            new ContactInfo("fio9", "adr9"),
            new ContactInfo("fio11", "adr11"),
            new ContactInfo("fio12", "adr12"),
            new ContactInfo("fio13", "adr13"),
            new ContactInfo("fio14", "adr14"),
            new ContactInfo("fio15", "adr15"),
            new ContactInfo("fio16", "adr16"),
            new ContactInfo("fio17", "adr17"),
            new ContactInfo("fio18", "adr18"),
            new ContactInfo("fio19", "adr19")
    );

//    @Inject
//    AppResources appResources;

    AppResources appResources = GWT.create(AppResources.class);

    EchoDataNavigation() {

        initWidget(binder.createAndBindUi(this));

//        ImageResource maleSilhouette = AppResources.INSTANCE.maleSilhouette();
        ImageResource maleSilhouette = appResources.maleSilhouette();
        ContactCell contactCell = new ContactCell(maleSilhouette);
//        ContactCell contactCell = new ContactCell();

        // Create a CellList that uses the cell.
        CellList<ContactInfo> cellList = new CellList<ContactInfo>(contactCell);

        // Set the total row count. This isn't strictly necessary, but it affects
        // paging calculations, so its good habit to keep the row count up to date.
        cellList.setRowCount(Contacts.size(), true);

        // Push the data into the widget.
        cellList.setRowData(0, Contacts);

        patientListPanel.add(cellList);
    }

//    static class ContactCell extends AbstractCell<ContactInfo> {
//
//        /**
//         * The html of the image used for contacts.
//         */
//        private final String imageHtml;
//
//        public ContactCell(ImageResource image) {
//            this.imageHtml = AbstractImagePrototype.create(image).getHTML();
//        }
//
//        @Override
//        public void render(Context context, ContactInfo value, SafeHtmlBuilder sb) {
//            // Value can be null, so do a null check..
//            if (value == null) {
//                return;
//            }
//
//            sb.appendHtmlConstant("<table>");
//
//            // Add the contact image.
//            sb.appendHtmlConstant("<tr><td rowspan='3'>");
//            sb.appendHtmlConstant(imageHtml);
//            sb.appendHtmlConstant("</td>");
//
//            // Add the name and address.
//            sb.appendHtmlConstant("<td style='font-size:95%;'>");
//            sb.appendEscaped(value.getFullName());
//            sb.appendHtmlConstant("</td></tr><tr><td>");
//            sb.appendEscaped(value.getAddress());
//            sb.appendHtmlConstant("</td></tr></table>");
//        }
//    }

}

