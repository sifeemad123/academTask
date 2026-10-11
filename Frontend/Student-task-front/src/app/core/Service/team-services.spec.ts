import { TestBed } from '@angular/core/testing';
import { TeamServices } from './team-services';

describe('TeamServices', () => {
  let service: TeamServices;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TeamServices);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
