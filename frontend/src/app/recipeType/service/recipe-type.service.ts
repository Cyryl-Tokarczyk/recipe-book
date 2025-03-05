import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {RecipeTypes} from "../model/recipeTypes";
import { RecipeTypeForm } from '../model/recipeTypeForm';
import { RecipeType } from '../model/recipeType';

@Injectable()
export class RecipeTypeService {


  private readonly address: string = `/api/recipeTypes`

  constructor(private http: HttpClient) { }

  getRecipeTypes(): Observable<RecipeTypes> {
    return this.http.get<RecipeTypes>(this.address)
  }

  getRecipeType(uuid: string): Observable<RecipeTypeForm> {
    return this.http.get<RecipeTypeForm>(this.address + '/' + uuid)
  }

  putRecipeType(recipeType: RecipeTypeForm): Observable<any> {
    return this.http.put(this.address, recipeType)
  }

  putRecipeTypeWithUuid(uuid: string, recipeType: RecipeTypeForm) {
    return this.http.put(this.address + '/' + uuid, recipeType)
  }

  deleteRecipeType(uuid: string): Observable<any> {
    return this.http.delete(this.address + '/' + uuid)
  }
}
