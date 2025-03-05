import {Component, OnInit} from '@angular/core';
import {RecipeTypeService} from "../../service/recipe-type.service";
import {RecipeTypes} from "../../model/recipeTypes";
import { RecipeType } from '../../model/recipeType';

@Component({
  selector: 'app-recipe-type-list',
  templateUrl: './recipe-type-list.component.html',
  styleUrl: './recipe-type-list.component.css'
})
export class RecipeTypeListComponent implements OnInit {

  constructor(private service: RecipeTypeService) { }

  recipeTypes: RecipeTypes | undefined

  ngOnInit() {
    this.service.getRecipeTypes().subscribe(recipeTypes => this.recipeTypes = recipeTypes)
  }

  onDelete(recipeType: RecipeType) {
    this.service.deleteRecipeType(recipeType.first).subscribe(() => this.ngOnInit())
  }

}
