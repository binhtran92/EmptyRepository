//package com.liferay.training.newsletter.service.search.query;
///**
// * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
// * <p>
// * This library is free software; you can redistribute it and/or modify it under
// * the terms of the GNU Lesser General Public License as published by the Free
// * Software Foundation; either version 2.1 of the License, or (at your option)
// * any later version.
// * <p>
// * This library is distributed in the hope that it will be useful, but WITHOUT
// * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
// * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
// * details.
// */
//
//import com.liferay.portal.kernel.search.SearchContext;
//import com.liferay.portal.kernel.search.filter.BooleanFilter;
//import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
//import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
//import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.Reference;
//
///**
// * @author Son Truong
// */
//
//@Component(
//        immediate = true,
//        property = "indexer.class.name=com.liferay.training.newsletter.issue.model.NewsletterIssue",
//        service = ModelPreFilterContributor.class
//)
//public class NewsletterIssueModelPreFilterContributor implements ModelPreFilterContributor {
//    @Override
//    public void contribute(BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings, SearchContext searchContext) {
//        _workflowStatusModelPreFilterContributor.contribute(booleanFilter, modelSearchSettings, searchContext);
//    }
//
//    @Reference(target = "(model.pre.filter.contributor.id=WorkflowStatus)")
//    private ModelPreFilterContributor _workflowStatusModelPreFilterContributor;
//}
