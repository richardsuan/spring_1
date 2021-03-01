import { Component, OnInit } from '@angular/core';
import { AutorService } from 'src/app/services/autor/autor.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-editorialcontrol',
  templateUrl: './editorialcontrol.component.html',
  styleUrls: ['./editorialcontrol.component.css']
})
export class EditorialcontrolComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
