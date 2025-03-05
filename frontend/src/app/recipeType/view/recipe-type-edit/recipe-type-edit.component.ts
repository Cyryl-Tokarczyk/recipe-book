import { Component } from '@angular/core';
import { RecipeTypeForm } from '../../model/recipeTypeForm';
import { RecipeTypeService } from '../../service/recipe-type.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-recipe-type-edit',
  templateUrl: './recipe-type-edit.component.html',
  styleUrl: './recipe-type-edit.component.css'
})
export class RecipeTypeEditComponent {

  uuid: string | undefined
  recipeType: RecipeTypeForm | undefined
  original: RecipeTypeForm | undefined

  constructor(private service: RecipeTypeService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getRecipeType(params['uuid'])
        .subscribe(recipeType => {
          this.uuid = params['uuid']
          this.recipeType = { name: recipeType.name }
          this.original = { ...this.recipeType }
          console.log(this.recipeType)
        })
    })
  }

  onSubmit() {    
    this.service.putRecipeTypeWithUuid(this.uuid!, this.recipeType!)
      .subscribe(() => this.router.navigate(['/recipeType']))
  }

}
