const API_URL = import.meta.env.VITE_API_URL || process.env.VUE_APP_API_URL

export const fetchClients = async () => {
    console.log('Calling API at:', API_URL) // Pour debug
    const response = await fetch(`${API_URL}/clients`)
    return response.json()
} 