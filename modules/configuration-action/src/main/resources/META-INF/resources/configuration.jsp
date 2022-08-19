<%--
/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
--%>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>

<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL
	portletConfiguration="<%= true %>"
	var="configurationActionURL"
/>

<liferay-portlet:renderURL
	portletConfiguration="<%= true %>"
	var="configurationRenderURL"
/>

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input
		name="<%= Constants.CMD %>"
		type="hidden"
		value="<%= Constants.UPDATE %>"
	/>

	<aui:input
		name="redirect"
		type="hidden"
		value="<%= configurationRenderURL %>"
	/>

	<aui:fieldset>
		<aui:select
			label="Font Family"
			name="fontFamily"
			value="<%= fontFamily %>"
		>
			<aui:option value="Arial">Arial</aui:option>
			<aui:option value="Comic Sans MS">Comic Sans MS</aui:option>
			<aui:option value="Courier New">Courier New</aui:option>
			<aui:option value="Georgia">Georgia</aui:option>
			<aui:option value="Verdana">Verdana</aui:option>
		</aui:select>

		<aui:select label="Font Size" name="fontSize" value="<%= fontSize %>">
			<aui:option value="100px">100px</aui:option>
			<aui:option value="11px">11px</aui:option>
			<aui:option value="12px">12px</aui:option>
			<aui:option value="13px">13px</aui:option>
			<aui:option value="14px">14px</aui:option>
			<aui:option value="35px">35px</aui:option>
		</aui:select>

		<aui:select
			label="Font Color"
			name="fontColor"
			value="<%= fontColor %>"
		>
			<aui:option value="violet">Violet</aui:option>
			<aui:option value="indigo">Indigo</aui:option>
			<aui:option value="blue">Blue</aui:option>
			<aui:option value="green">Green</aui:option>
			<aui:option value="yellow">Yellow</aui:option>
			<aui:option value="orange">Orange</aui:option>
			<aui:option value="red">Red</aui:option>
		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit"></aui:button>
	</aui:button-row>
</aui:form>