import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { Sum } from './Sum';

describe('AppComponent', () => {
  let access = new AppComponent();

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RouterTestingModule],
      declarations: [AppComponent],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'angular-testing'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('angular-testing');
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('.content span')?.textContent).toContain(
      'angular-testing app is running!'
    );
  });

  it('Chris TestCase', () => {
    expect(true).toBe(true);
  });

  it('Display TestCase', () => {
    expect(access.showDisplay('Krishna')).toBe('Krishna');
  });

  it('Show the Sum result', () => {
    expect(Sum(12, 12)).toBe(24);
  })

  it('Use PreDefined Functionalities toBeGreaterThan', () => {
    expect(Sum(12, 12)).toBeGreaterThan(23);
  });
});
