/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.newsletter.service.persistence;

import com.liferay.newsletter.model.Issue;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the issue service. This utility wraps <code>com.liferay.newsletter.service.persistence.impl.IssuePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author quanhuynhces
 * @see IssuePersistence
 * @generated
 */
public class IssueUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Issue issue) {
		getPersistence().clearCache(issue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Issue> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Issue> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Issue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Issue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Issue> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Issue update(Issue issue) {
		return getPersistence().update(issue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Issue update(Issue issue, ServiceContext serviceContext) {
		return getPersistence().update(issue, serviceContext);
	}

	/**
	 * Returns all the issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching issues
	 */
	public static List<Issue> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @return the range of matching issues
	 */
	public static List<Issue> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching issues
	 */
	public static List<Issue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Issue> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the issues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching issues
	 */
	public static List<Issue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Issue> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue
	 * @throws NoSuchIssueException if a matching issue could not be found
	 */
	public static Issue findByUuid_First(
			String uuid, OrderByComparator<Issue> orderByComparator)
		throws com.liferay.newsletter.exception.NoSuchIssueException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching issue, or <code>null</code> if a matching issue could not be found
	 */
	public static Issue fetchByUuid_First(
		String uuid, OrderByComparator<Issue> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue
	 * @throws NoSuchIssueException if a matching issue could not be found
	 */
	public static Issue findByUuid_Last(
			String uuid, OrderByComparator<Issue> orderByComparator)
		throws com.liferay.newsletter.exception.NoSuchIssueException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last issue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching issue, or <code>null</code> if a matching issue could not be found
	 */
	public static Issue fetchByUuid_Last(
		String uuid, OrderByComparator<Issue> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the issues before and after the current issue in the ordered set where uuid = &#63;.
	 *
	 * @param issueId the primary key of the current issue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next issue
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	public static Issue[] findByUuid_PrevAndNext(
			long issueId, String uuid,
			OrderByComparator<Issue> orderByComparator)
		throws com.liferay.newsletter.exception.NoSuchIssueException {

		return getPersistence().findByUuid_PrevAndNext(
			issueId, uuid, orderByComparator);
	}

	/**
	 * Removes all the issues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of issues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching issues
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the issue in the entity cache if it is enabled.
	 *
	 * @param issue the issue
	 */
	public static void cacheResult(Issue issue) {
		getPersistence().cacheResult(issue);
	}

	/**
	 * Caches the issues in the entity cache if it is enabled.
	 *
	 * @param issues the issues
	 */
	public static void cacheResult(List<Issue> issues) {
		getPersistence().cacheResult(issues);
	}

	/**
	 * Creates a new issue with the primary key. Does not add the issue to the database.
	 *
	 * @param issueId the primary key for the new issue
	 * @return the new issue
	 */
	public static Issue create(long issueId) {
		return getPersistence().create(issueId);
	}

	/**
	 * Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue that was removed
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	public static Issue remove(long issueId)
		throws com.liferay.newsletter.exception.NoSuchIssueException {

		return getPersistence().remove(issueId);
	}

	public static Issue updateImpl(Issue issue) {
		return getPersistence().updateImpl(issue);
	}

	/**
	 * Returns the issue with the primary key or throws a <code>NoSuchIssueException</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	public static Issue findByPrimaryKey(long issueId)
		throws com.liferay.newsletter.exception.NoSuchIssueException {

		return getPersistence().findByPrimaryKey(issueId);
	}

	/**
	 * Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue, or <code>null</code> if a issue with the primary key could not be found
	 */
	public static Issue fetchByPrimaryKey(long issueId) {
		return getPersistence().fetchByPrimaryKey(issueId);
	}

	/**
	 * Returns all the issues.
	 *
	 * @return the issues
	 */
	public static List<Issue> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @return the range of issues
	 */
	public static List<Issue> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of issues
	 */
	public static List<Issue> findAll(
		int start, int end, OrderByComparator<Issue> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the issues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IssueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of issues
	 * @param end the upper bound of the range of issues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of issues
	 */
	public static List<Issue> findAll(
		int start, int end, OrderByComparator<Issue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the issues from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of issues.
	 *
	 * @return the number of issues
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IssuePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<IssuePersistence, IssuePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(IssuePersistence.class);

		ServiceTracker<IssuePersistence, IssuePersistence> serviceTracker =
			new ServiceTracker<IssuePersistence, IssuePersistence>(
				bundle.getBundleContext(), IssuePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}