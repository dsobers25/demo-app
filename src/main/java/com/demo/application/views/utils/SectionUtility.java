package com.demo.application.views.utils;

import com.vaadin.flow.component.html.Paragraph;

import lombok.Getter;

@Getter
public class SectionUtility {

    Paragraph[][] leftside;

    Paragraph[][] rightside;

    int rows;

    public SectionUtility(Paragraph[][] left, Paragraph[][] right) {

        this.leftside = left;
        this.rightside = right;

        // handle error when both left and right don't equal same length
        if(left.length == right.length && left != null && right != null) {
            this.rows = left.length;
        }
    }

}
