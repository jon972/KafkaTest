export interface Client {
  id?: number;
  nom: string;
  prenom: string;
  age: number | null;
  dateNaissance: string;
  lieuNaissance: string;
}