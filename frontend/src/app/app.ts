import {Component} from 'angular2/core';
import {PersonListComponent} from "./components/personList";

@Component({
    selector: 'app',
    templateUrl: 'app/app.html',
    directives: [PersonListComponent]
})
export class App {


}

