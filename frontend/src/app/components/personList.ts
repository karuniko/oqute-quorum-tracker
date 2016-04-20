import {Component, OnInit} from 'angular2/core';
import * as Rx from "rxjs/Rx";
import {Person} from "../common/person.ts";
import {PersonService} from '../service/personService';

@Component({
    selector: 'persons',
    templateUrl: 'app/components/personList.html',
    providers: [PersonService]
})
export class PersonListComponent implements OnInit {
  constructor (private _personService: PersonService) {}
  errorMessage: string;
  persons:Person[];
  ngOnInit() { this.getPersons(); }
  getPersons() {
    this._personService.getPersons()
                     .subscribe(
                       persons => this.persons = persons,
                       error =>  this.errorMessage = <any>error);
  }
  
}