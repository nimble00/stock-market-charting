import { Component, OnInit } from '@angular/core';
import { UploaderService } from "../../services/uploader.service";
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-uploader',
  templateUrl: './uploader.component.html',
  styleUrls: ['./uploader.component.css'],
  providers: [ UploaderService ]
})
export class UploaderComponent {

  message: string;
  form: FormGroup;

  constructor(private uploaderService: UploaderService) {
    this.form = new FormGroup({
      input: new FormControl()
   });
  }

  onPicked(input: HTMLInputElement) {
    const file = input.files[0];
    if (file) {
      this.uploaderService.upload(file).subscribe(
        msg => {
          input.value = null;
          this.message = msg;
        }
      );
    }
  }
}
