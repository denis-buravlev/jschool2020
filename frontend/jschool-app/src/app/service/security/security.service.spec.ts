import { TestBed } from '@angular/core/testing';

import { SecurityService } from './security-service.service';

describe('SecurityServiceService', () => {
  let service: SecurityService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SecurityService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
