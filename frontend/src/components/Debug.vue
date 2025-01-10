<template>
  <div class="debug-info">
    API URL: {{ apiUrl }}
  </div>
</template>

<script>
export default {
  name: 'Debug',
  computed: {
    apiUrl() {
      return import.meta.env.VITE_API_URL || process.env.VUE_APP_API_URL
    }
  }
}
</script>

<style scoped>
.debug-info {
  position: fixed;
  bottom: 0;
  right: 0;
  padding: 10px;
  background: #eee;
}
</style> 