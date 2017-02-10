<md-button aria-label="menu" class="md-fab md-raised md-primary md-scale md-fab-bottom-right" data-ng-click="openDashboardDetailsModal({}, true)" style="position: fixed">
    <i class="fa fa-plus" aria-hidden="true"></i>
</md-button>
<md-content class="md-padding" layout-xs="column" layout="column" style="background-color: white">
    <div>
        <md-card class="news-card" md-theme-watch ng-repeat="event in events">
            <md-card-header>
                <md-card-avatar>
                    <img class="md-user-avatar" src="/resources/images/1.jpg"/>
                </md-card-avatar>
                <md-card-header-text>
                    <span class="md-title">{{event.eventOwner.name}}</span>
                </md-card-header-text>
            </md-card-header>
            <md-card-title layout="column">
                <span class="md-subhead">{{event.description}}</span>
                <md-card-title-media class="md-padding">
                    <div class="md-media-lg card-media">
                        <img data-ng-click="openImageModal($event)" ng-src="/resources/images/1.jpg" class="md-card-image" style="height: 100%; width: 100%"/>
                    </div>
                </md-card-title-media>
            </md-card-title>
            <md-card-actions layout="row" layout-align="end">
                <div layout="row" layout-align="center center" layout-xs="column">
                    {{likes}}
                    <md-button data-ng-model="event.id" data-ng-click="addLike()" class="md-icon-button" aria-label="Favorite">
                        <md-icon md-svg-icon="/resources/images/img/icons/favorite.svg"></md-icon>
                    </md-button>
                    <md-button class="md-icon-button" aria-label="Settings">
                        <md-icon md-svg-icon="/resources/images/img/icons/menu.svg"></md-icon>
                    </md-button>
                    <md-button class="md-icon-button" aria-label="Share">
                        <md-icon md-svg-icon="/resources/images/img/icons/share-arrow.svg"></md-icon>
                    </md-button>
                </div>
            </md-card-actions>
        </md-card>
    </div>
</md-content>