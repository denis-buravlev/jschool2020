import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {CurrentUserService} from '../current-user/current-user.service';
import {Observable} from 'rxjs';
import {Device} from '../../model/device';

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  constructor(
    private http: HttpClient,
    private currentUserService: CurrentUserService
  ) {
  }

  getDevices(): Observable<Device[]> {
    return this.http.get<Device[]>('api/v1/devices', this.buildOpts());
  }

  createDevice(device: Device): Observable<Device> {
    return this.http.post<Device>('api/v1/devices', device, this.buildOpts());
  }

  updateDevice(device: Device): Observable<Device> {
    return this.http.put<Device>(`api/v1/devices/${device.id}`, device, this.buildOpts());
  }

  deleteDevice(deviceId: number): Observable<void> {
    return this.http.delete<void>(`api/v1/devices/${deviceId}`, this.buildOpts());
  }

  private buildOpts(): object {
    return {
      headers: new HttpHeaders({
        Authorization: `Bearer ${this.currentUserService.getToken()}`
      })
    };
  }


}

