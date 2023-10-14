import { Component } from '@angular/core';
import { ApiService } from './api.service';
import { Todo } from './types';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title: string = 'todos-app';
  todos: Todo[] = [];
  description = '';
  summary = '';
  constructor(private todo: ApiService) {
    this.todo.getTodos().subscribe((data) => {
      console.warn(data);
      this.todos = data;
    });
  }
  public refreshTodos() {
    this.todo.getTodos().subscribe((data) => {
      this.todos = data;
    });
  }
  public deleteTodo(id: number) {
    this.todo.deleteTodo(id).subscribe((data) => {
      console.log(data);
      this.refreshTodos();
    });
  }

  public createTodo() {
    this.todo
      .postTodo({ id: 0, summary: this.summary, description: this.description })
      .subscribe((data) => {
        console.log(data);
        this.refreshTodos();
      });
  }
}
