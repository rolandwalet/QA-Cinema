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
    this.filmService.getCurrentFilms().subscribe(data => {
      this.films = data;
      console.log(data);
    });

    this.filmService.getAllShowings().subscribe(
    data => {
      this.showings = data;
      console.log(data);
      this.populateFilms();
    },
    err => console.log(err),
    () => {
      console.log('data loaded');
    }
      );
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
      el.innerHTML += "<p><b>Showing: </b></p>";
      htmlToAdd += "<table style=\"margin-bottom: 5em;\"><th>Date</th><th>Times</th>";
      for (showingIndex; showingIndex < this.showings.length; showingIndex++) {
        if(this.showings[showingIndex].film.id == this.films[index].id) {
          console.log("id's match");
          htmlToAdd += "<tr>";
          if (showingIndex == 0) {
            console.log("first run, i == 0");
            htmlToAdd += "<td style=\"padding-right:4em; border-top: 2px solid black;\">" + this.showings[showingIndex].date + "</td>";
            htmlToAdd += "<td style=\"padding-right:4em; font-weight:bold; border-top: 2px solid black;\">" + "<a style=\"text-decoration: none; color: black;\" href=\"/booking/" + this.showings[showingIndex].id + "\">" + this.showings[showingIndex].time + "</a></td>";
            currentDate = this.showings[showingIndex].date
          }
          // else if (this.films[index].id != currentFilmID) {
          //   htmlToAdd += "<td>" + this.showings[showingIndex].date + "</td>";
          //   htmlToAdd += "<td>" + this.showings[showingIndex].time + "</td>";
          // }
          else if (this.showings[showingIndex].date != currentDate) {
            console.log("no match");
            htmlToAdd += "<td style=\"padding-right:4em; border-top: 2px solid black;\">" + this.showings[showingIndex].date + "</td>";
            htmlToAdd += "<td style=\"padding-right:4em; font-weight:bold; border-top: 2px solid black;\">" + "<a style=\"text-decoration: none; color: black;\" href=\"/booking/" + this.showings[showingIndex].id + "\">" + this.showings[showingIndex].time + "</a></td>";
            currentDate = this.showings[showingIndex].date;
          }
          else {
            console.log("dates do match");
            console.log("current date: " + this.showings[showingIndex].date + " previous date: " + this.showings[showingIndex - 1].date);
            htmlToAdd += "<td style=\"padding-right:4em\"></td>";
            htmlToAdd += "<td style=\"padding-right:4em; font-weight:bold;\">" + "<a style=\"text-decoration: none; color: black;\" href=\"/booking/" + this.showings[showingIndex].id + "\">" + this.showings[showingIndex].time + "</a></td>";
          }
          htmlToAdd += "</tr>";
        }
      }
      currentFilmID = this.films[index].id;
      currentDate = "";
      htmlToAdd += "</table>";
      el.innerHTML += htmlToAdd;
      htmlToAdd = "";
      showingIndex = 0;








      // for (let i = 0; i < this.showings.length; ++i) {
      //   // console.log(this.showings[i].film.id);
      //   htmlToAdd += "<tr>";
      //   //el.innerHTML += this.showings[i].date;
      //   if(i == 0) {
      //     console.log("i == 0")
      //     if (this.showings[i].film.id == this.films[index].id) {
      //       htmlToAdd += "<td>" + this.showings[i].date + "</td>";
      //       htmlToAdd += "<td>" + this.showings[i].time + "</td>";
      //     }
      //   }
      //   else {
      //     console.log(this.showings[i].film.id);
      //     console.log("current showing: " + this.showings[i].date + "previous: " + this.showings[i - 1].date);
      //     if (this.showings[i].date != this.showings[i -1].date) {
      //       console.log(this.showings[i].film.id);
      //       if (this.showings[i].film.id == this.films[index].id) {
      //         console.log("id is same, date added");
      //         htmlToAdd += "<td>" + this.showings[i].date + "</td>";
      //         htmlToAdd += "<td>" + this.showings[i].time + "</td>";
      //       }
      //     }
      //     else{
      //       console.log(this.showings[i].film.id);
      //       if (this.showings[i].film.id == this.films[index].id) {
      //         htmlToAdd += "<td></td>";
      //         htmlToAdd += "<td>" + this.showings[i].time + "</td>";
      //       }
      //     }
      //   }
      //   htmlToAdd += "</tr>";
      // }
      // htmlToAdd += "</table>";
      // el.innerHTML += htmlToAdd;
      // htmlToAdd="";
    }

  }
}
