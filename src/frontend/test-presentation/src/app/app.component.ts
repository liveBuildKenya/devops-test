import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Subscription } from 'rxjs';
import { environment } from '../environments/environment';
import { TestItem } from '../models/test-item.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Presentation';
  subscriptions: Array<Subscription> = [];

  testItems: Array<TestItem> = [];

  constructor(private httpClient: HttpClient){}

  ngOnInit(){
    this.loadTestItems();
  }

  loadTestItems(){
    const testItemSubscription = this.httpClient.get(environment.apiUrl + 'test')
    .subscribe((responseData: any) => {
      this.testItems = [...this.testItems, ...responseData];
    });

    this.subscriptions.push(testItemSubscription);
  }

  ngOnDestroy(){
    this.subscriptions.forEach(subscription => {
      subscription.unsubscribe();
    })
  }
}
