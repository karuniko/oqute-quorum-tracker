///<reference path="../../node_modules/angular2/typings/browser.d.ts"/>
///<reference path="../../typings/browser.d.ts"/>
import {bootstrap} from 'angular2/platform/browser';

import {LocationStrategy,HashLocationStrategy} from 'angular2/router';
import {PersonService} from './service/personService';
import {App} from './app';
import {enableProdMode} from 'angular2/core';
import { HTTP_PROVIDERS } from 'angular2/http';

enableProdMode();
bootstrap(App, [HTTP_PROVIDERS, PersonService]);