<script setup lang="ts">
import { ref } from 'vue'
import type { Client } from '../types'

const emit = defineEmits(['client-added'])

const client = ref<Client>({
  nom: '',
  prenom: '',
  age: null,
  dateNaissance: '',
  lieuNaissance: ''
})

const submitForm = async () => {
  try {
    const response = await fetch(`${import.meta.env.VITE_API_URL}/clients`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(client.value)
    })
    
    if (response.ok) {
      const newClient = await response.json()
      emit('client-added', newClient)
      // Reset form
      client.value = {
        nom: '',
        prenom: '',
        age: null,
        dateNaissance: '',
        lieuNaissance: ''
      }
    }
  } catch (error) {
    console.error('Error:', error)
  }
}
</script>

<template>
  <div class="client-form">
    <h2>Nouveau Client</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" v-model="client.nom" required>
      </div>
      
      <div class="form-group">
        <label for="prenom">Prénom:</label>
        <input type="text" id="prenom" v-model="client.prenom" required>
      </div>
      
      <div class="form-group">
        <label for="age">Age:</label>
        <input type="number" id="age" v-model="client.age" required>
      </div>
      
      <div class="form-group">
        <label for="dateNaissance">Date de Naissance:</label>
        <input type="date" id="dateNaissance" v-model="client.dateNaissance" required>
      </div>
      
      <div class="form-group">
        <label for="lieuNaissance">Lieu de Naissance:</label>
        <input type="text" id="lieuNaissance" v-model="client.lieuNaissance" required>
      </div>
      
      <button type="submit">Ajouter Client</button>
    </form>
  </div>
</template>

<style scoped>
.client-form {
  max-width: 500px;
  margin: 0 auto;
  padding: 20px;
}

.form-group {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}

input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 10px 15px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>