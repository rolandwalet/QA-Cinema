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
  populateFilms() {
    var showingIndex = 0;
    var currentFilmID;
    var currentDate;
    var el = document.getElementById('pageContent');
    el.innerHTML = "";
    var htmlToAdd = "";
    for (let index = 0; index < this.films.length; ++index) {
      console.log(index);

      el.innerHTML +=  "<img style=\"width: 70%; max-width: 600px; height: auto;\" src=\"" + this.films[index].poster + "\"/>" ;
      el.innerHTML += "<br />";
      el.innerHTML += "<h3>" + this.films[index].title + "</h3>";
      el.innerHTML += "<p><b>Run time: </b>" + this.films[index].runTime + " minutes </p>";
      el.innerHTML += "<p>" + this.films[index].synopsis + "</p>";
      el.innerHTML += "<p><b>Starring: </b>" + this.films[index].actors + "</p>";
      el.innerHTML += "<p><b>Directed By: </b>" + this.films[index].director.name + "</p>";

      }
      currentFilmID = this.films[index].id;
      currentDate = "";
      htmlToAdd += "</table>";
      el.innerHTML += htmlToAdd;
      htmlToAdd = "";
      showingIndex = 0;
    }
}
