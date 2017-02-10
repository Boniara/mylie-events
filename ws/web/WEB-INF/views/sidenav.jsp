<%--
  Created by IntelliJ IDEA.
  User: bogdan
  Date: 1/28/2017
  Time: 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div layout="column" flex-gt-md="20">
    <section layout="row">
        <md-sidenav class="md-sidenav-left" md-component-id="left" md-is-locked-open="$mdMedia('gt-md')">
            <md-toolbar ng-click="openUserProfile()">
                <img class="md-user-avatar" src="/resources/images/1.jpg"/>
                <h1 class="md-toolbar-tools">username</h1>
            </md-toolbar>
            <md-content layout="column">
                <md-button class="md-raised">My profile</md-button>
                <md-button class="md-raised">My events</md-button>
                <md-button class="md-raised">My score</md-button>
                <md-button class="md-raised">Settings</md-button>
            </md-content>
        </md-sidenav>
    </section>
</div>