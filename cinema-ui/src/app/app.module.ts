import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule, MatCheckboxModule, MatToolbarModule, MatMenuModule, MatIconModule, MatCardModule} from '@angular/material';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms'

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ListingsGalleryComponent } from './components/listings-gallery/listings-gallery.component';
import { FutureReleasesComponent } from './components/future-releases/future-releases.component';
import { BookingComponent } from './components/booking/booking.component';
import { OpeningTimesComponent } from './components/opening-times/opening-times.component';
import { ClassificationsComponent } from './components/classifications/classifications.component';
import { ScreensComponent } from './components/screens/screens.component';
import { ContactComponent } from './components/contact/contact.component';
import { MessageBoardComponent } from './components/message-board/message-board.component';
import { LocalVenuesComponent } from './components/local-venues/local-venues.component';
import { LocationComponent } from './components/location/location.component';
import { AboutUsComponent } from './components/about-us/about-us.component';


const appRoutes: Routes = [
  { path: '', redirectTo '/home', pathMatch: 'full'},
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'listings-gallery',
    component: ListingsGalleryComponent
  },
  {
    path: 'future-releases',
    component: FutureReleasesComponent
  },
  {
    path: 'booking',
    component: BookingComponent
  },
  {
    path: 'opening-times',
    component: OpeningTimesComponent
  },
  {
    path: 'classifications',
    component: ClassificationsComponent
  },
  {
    path: 'screens',
    component: ScreensComponent
  },
  {
    path: 'contact',
    component: ContactComponent
  },
  {
    path: 'message-board',
    component: MessageBoardComponent
  },
  {
    path: 'local-venues',
    component: LocalVenuesComponent
  },
  {
    path: 'location',
    component: LocationComponent
  },
  {
    path: 'about-us',
    component: AboutUsComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ListingsGalleryComponent,
    FutureReleasesComponent,
    BookingComponent,
    OpeningTimesComponent,
    ClassificationsComponent,
    ScreensComponent,
    ContactComponent,
    MessageBoardComponent,
    LocalVenuesComponent,
    LocationComponent,
    AboutUsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatMenuModule,
    MatCardModule,
    MatIconModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
