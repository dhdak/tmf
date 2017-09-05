/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tmf.dsmapi.domain.organization;

public enum OrganizationEventTypeEnum {

    OrganizationCreationNotification("OrganizationCreationNotification"),
    OrganizationUpdateNotification("OrganizationUpdateNotification"),
    OrganizationDeletionNotification("OrganizationDeletionNotification"),
    OrganizationValueChangeNotification("OrganizationValueChangeNotification");

    private String text;

    OrganizationEventTypeEnum(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return this.text;
    }

    /**
     *
     * @param text
     * @return
     */
    public static OrganizationEventTypeEnum fromString(String text) {
        if (text != null) {
            for (OrganizationEventTypeEnum b : OrganizationEventTypeEnum.values()) {
                if (text.equalsIgnoreCase(b.text)) {
                    return b;
                }
            }
        }
        return null;
    }
}