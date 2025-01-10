<script setup lang="ts">
import ClientForm from './components/ClientForm.vue'
import ClientList from './components/ClientList.vue'
import { ref } from 'vue'

const clientListRef = ref()

const handleClientAdded = () => {
  clientListRef.value?.fetchClients()
}
</script>

<template>
  <div class="app">
    <h1>Gestion des Clients</h1>
    <div class="container">
      <ClientForm @client-added="handleClientAdded" />
      <ClientList ref="clientListRef" />
    </div>
  </div>
</template>

<style>
.app {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.container {
  display: grid;
  grid-template-columns: 1fr 2fr;
  gap: 20px;
}

h1 {
  text-align: center;
  color: #2c3e50;
  margin-bottom: 30px;
}

@media (max-width: 768px) {
  .container {
    grid-template-columns: 1fr;
  }
}
</style>