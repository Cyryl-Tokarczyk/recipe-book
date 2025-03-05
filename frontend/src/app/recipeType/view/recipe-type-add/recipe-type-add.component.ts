import { Component } from '@angular/core';
import { RecipeTypeForm } from '../../model/recipeTypeForm';
import { RecipeTypeService } from '../../service/recipe-type.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-recipe-type-add',
  templateUrl: './recipe-type-add.component.html',
  styleUrl: './recipe-type-add.component.css'
})
export class RecipeTypeAddComponent {

  recipeType: RecipeTypeForm | undefined

  constructor(private service: RecipeTypeService, private router: Router) {}

  ngOnInit() {
    this.recipeType = { name: '' }
  }

  onSubmitAdd() {
    this.service.putRecipeType(this.recipeType!)
      .subscribe(() => this.router.navigate(['/recipeType']))
  }

}
