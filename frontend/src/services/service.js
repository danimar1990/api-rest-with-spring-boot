import api from './api';

export async function getCars() {
  const response = await api.get('cars');
  return response.data;
}

export async function getCar(id) {
  const response = await api.get(`car/${id}`);
  return response.data;
}

export async function getCarsByBrand(type) {
  const response = await api.get(`brand/${brand}`);
  return response.data;
}

export async function createCar(form, headers) {
  const response = await api.post('car/save', form, headers);
  return response.data;
}

export async function updateCar(id, form = {}, headers) {
  const response = await api.put(`car/${id}/update`, form, headers);
  return response.data;
}

export async function deleteCar(id) {
  const response = await api.delete(`car/${id}/delete`);
  return response.data;
}
