import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NavComponent } from './component/nav/nav.component';
import { RecipeTypeListComponent } from './recipeType/view/recipe-type-list/recipe-type-list.component';
import { RecipeTypeService } from './recipeType/service/recipe-type.service';
import { RecipeTypeViewComponent } from './recipeType/view/recipe-type-view/recipe-type-view.component';
import { RecipeTypeAddComponent } from './recipeType/view/recipe-type-add/recipe-type-add.component';
import { RecipeTypeEditComponent } from './recipeType/view/recipe-type-edit/recipe-type-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    RecipeTypeListComponent,
    RecipeTypeViewComponent,
    RecipeTypeAddComponent,
    RecipeTypeEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
    RecipeTypeService,
    provideClientHydration()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
