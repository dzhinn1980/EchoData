package ru.dzhinn.echodata.web.gwt.client.widget.navigation.render;


import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.ui.AbstractImagePrototype;

/**
 * Created by A.Dzhioev on 08.02.2017.
 */
public class ContactCell extends AbstractCell<ContactInfo> {

    private final String imageHtml;

    public ContactCell(ImageResource image) {
        this.imageHtml = AbstractImagePrototype.create(image).getHTML();
    }

    public ContactCell(){imageHtml = "photo";}


    @Override
    public void render(Context context, ContactInfo value, SafeHtmlBuilder sb) {
        if (value == null) {
            return;
        }

        sb.appendHtmlConstant("<table>");

        // Add the contact image.
        sb.appendHtmlConstant("<tr><td rowspan='3'>");
        sb.appendHtmlConstant(imageHtml);
        sb.appendHtmlConstant("</td>");

        // Add the name and dateOfBirth.
        sb.appendHtmlConstant("<td style='font-size:95%;'>");
        sb.appendEscaped(value.getFullName());
        sb.appendHtmlConstant("</td></tr><tr><td>");
        sb.appendEscaped(value.getDateOfBirth());
        sb.appendHtmlConstant("</td></tr></table>");
    }
}
