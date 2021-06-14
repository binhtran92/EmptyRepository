/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.newsletter.service.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;
import com.liferay.training.newsletter.model.NewsletterIssue;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Son Truong
 */

@Component(
        immediate = true,
        service = {}
)
public class NewsletterIssueSearchRegistrar {
    @Activate
    protected void activate(BundleContext bundleContext) {

        _serviceRegistration = modelSearchRegistrarHelper.register(
                NewsletterIssue.class, bundleContext, modelSearchDefinition -> {
                    modelSearchDefinition.setDefaultSelectedFieldNames(Field.COMPANY_ID, Field.GROUP_ID,
                            Field.SCOPE_GROUP_ID);
                    modelSearchDefinition.setDefaultSelectedLocalizedFieldNames(
                            Field.DESCRIPTION, Field.TITLE);
                    modelSearchDefinition.setModelIndexWriteContributor(
                            modelIndexWriterContributor);
                    modelSearchDefinition.setModelSummaryContributor(
                            modelSummaryContributor);
                });
    }

    @Deactivate
    protected void deactivate() {

        _serviceRegistration.unregister();
    }

    @Reference(target = "(indexer.class.name=com.liferay.training.newsletter.model.NewsletterIssue)")
    protected ModelIndexerWriterContributor<NewsletterIssue> modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    @Reference(target = "(indexer.class.name=com.liferay.training.newsletter.model.NewsletterIssue)")
    protected ModelSummaryContributor modelSummaryContributor;

    private ServiceRegistration<?> _serviceRegistration;
}
