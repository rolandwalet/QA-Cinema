import { Component, OnInit } from '@angular/core';
import { FilmService } from '../../services/film/film.service';

@Component({
  selector: 'app-listings-gallery',
  templateUrl: './listings-gallery.component.html',
  styleUrls: ['./listings-gallery.component.css']
})
export class ListingsGalleryComponent implements OnInit {

  films: Array<any>;
  showings: Array<any>;

  constructor( private filmService: FilmService ) { }

  ngOnInit() {
    this.filmService.getAllFilms().subscribe(data => {
      this.films = data;
      console.log(data);
    });

    this.filmService.getAllShowings().subscribe(data => {
      this.showings = data;
      console.log(data);
    });
  }

}
