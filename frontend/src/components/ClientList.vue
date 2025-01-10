<script setup lang="ts">
import { ref, onMounted } from 'vue'
import type { Client } from '../types'

const clients = ref<Client[]>([])

const fetchClients = async () => {
  try {
    const response = await fetch(`${import.meta.env.VITE_API_URL}/clients`)
    if (response.ok) {
      clients.value = await response.json()
    }
  } catch (error) {
    console.error('Error:', error)
  }
}

onMounted(() => {
  fetchClients()
})

defineExpose({
  fetchClients
})
</script>

<template>
  <div class="client-list">
    <h2>Liste des Clients</h2>
    <table>
      <thead>
        <tr>
          <th>Nom</th>
          <th>Prénom</th>
          <th>Age</th>
          <th>Date de Naissance</th>
          <th>Lieu de Naissance</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="client in clients" :key="client.id">
          <td>{{ client.nom }}</td>
          <td>{{ client.prenom }}</td>
          <td>{{ client.age }}</td>
          <td>{{ new Date(client.dateNaissance).toLocaleDateString() }}</td>
          <td>{{ client.lieuNaissance }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
.client-list {
  margin: 20px;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
}

th, td {
  border: 1px solid #ddd;
  padding: 8px;
  text-align: left;
}

th {
  background-color: #f4f4f4;
}

tr:nth-child(even) {
  background-color: #f9f9f9;
}

tr:hover {
  background-color: #f5f5f5;
}
</style>