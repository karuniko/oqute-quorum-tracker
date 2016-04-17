///<reference path="../../node_modules/angular2/typings/browser.d.ts"/>
///<reference path="../../typings/browser.d.ts"/>
import {provide} from 'angular2/core';
import {bootstrap} from 'angular2/platform/browser';

import {ROUTER_PROVIDERS,LocationStrategy,HashLocationStrategy} from 'angular2/router';
import {PersonService} from './service/personService';
import {App} from './app';
import {enableProdMode} from 'angular2/core'

enableProdMode();
bootstrap(App, [ROUTER_PROVIDERS,provide(LocationStrategy,
    {useClass: HashLocationStrategy}),PersonService]);

