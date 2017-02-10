<%--
  Created by IntelliJ IDEA.
  User: bogdan
  Date: 1/28/2017
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="mylie-navbar" layout="row">
    <md-content class="md-block" flex>
        <md-nav-bar md-selected-nav-item="currentNavItem" nav-bar-aria-label="navigation links" layout="row" layout-align="end">
            <md-nav-item md-nav-click="goto('events_page')" name="events_page">All events</md-nav-item>
            <md-nav-item md-nav-click="goto('about_page')" name="about_page">About</md-nav-item>
            <div class="nav-buttons">
                <md-button class="md-raised md-accent">Sign out</md-button>
            </div>
        </md-nav-bar>
    </md-content>
</div>
