export const calculatePath = async (request) => {
  try {
    const response = await fetch('http://localhost:8080/api/calculate-path', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json'},
      body: JSON.stringify(request)
    })
    return await response.json();
  } catch (e) {
    console.log(e);
  }
}