import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RecipeTypeListComponent } from './recipeType/view/recipe-type-list/recipe-type-list.component';
import { RecipeTypeViewComponent } from './recipeType/view/recipe-type-view/recipe-type-view.component';
import { RecipeTypeAddComponent } from './recipeType/view/recipe-type-add/recipe-type-add.component';
import { RecipeTypeEditComponent } from './recipeType/view/recipe-type-edit/recipe-type-edit.component';

const routes: Routes = [
  {path: 'recipeType', component: RecipeTypeListComponent},
  {path: 'recipeType/:uuid', component: RecipeTypeViewComponent},
  {path: 'addRecipeType', component: RecipeTypeAddComponent},
  {path: 'recipeType/:uuid/edit', component: RecipeTypeEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
