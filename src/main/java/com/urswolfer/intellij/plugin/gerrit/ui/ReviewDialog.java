/*
 * Copyright 2013 Urs Wolfer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.urswolfer.intellij.plugin.gerrit.ui;

import javax.swing.*;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.NotNull;

/**
 * @author Urs Wolfer
 */
public class ReviewDialog extends DialogWrapper {

    private final ReviewPanel myReviewPanel;

    public ReviewDialog() {
        super(true);
        myReviewPanel = new ReviewPanel(this);
        setTitle("Review Change");
        setOKButtonText("Review");
        init();
    }

    @NotNull
    protected Action[] createActions() {
        return new Action[]{getOKAction(), getCancelAction(), getHelpAction()};
    }

    @Override
    protected JComponent createCenterPanel() {
        return myReviewPanel.getPanel();
    }

    @Override
    protected String getHelpId() {
        return "gerrit_review";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return myReviewPanel.getPreferrableFocusComponent();
    }

    @Override
    protected void doOKAction() {
        super.doOKAction();
    }

    public ReviewPanel getReviewPanel() {
        return myReviewPanel;
    }
}