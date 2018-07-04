import { Component, OnInit } from '@angular/core';
import { FilmService } from '../../services/film/film.service';


@Component({
  selector: 'app-future-releases',
  templateUrl: './future-releases.component.html',
  styleUrls: ['./future-releases.component.css']
})
export class FutureReleasesComponent implements OnInit {
  films: Array<any>;

  constructor( private filmService: FilmService ) { }

  ngOnInit() {
    this.filmService.getFutureFilms().subscribe(data => {
      this.films = data;
      console.log(data);
    });

  }
}
