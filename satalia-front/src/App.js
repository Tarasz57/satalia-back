import { useState } from 'react';
import './App.css';

function App() {

  const [formValues, setFormValues] = useState({latStart: '', lonStart: '', distance: '' });

  const handleSubmit = (event) => {
    console.log(formValues);
    event.preventDefault();
  }

  const handleChange = (event) => {
    const target = event.target;
    const name = target.name;
    setFormValues({
      ...formValues,
      [name]: target.value
    })
  }

  return (
    <div className="App">
      <form onSubmit={handleSubmit}>
        <label>
          Starting latitude:
          <input name="latStart" type="number" value={formValues.latStart} onChange={handleChange} />
        </label>
        <label>
          Starting longitude:
          <input name="lonStart" type="number" value={formValues.lonStart} onChange={handleChange} />
        </label>
        <label>
          Distance that can be travelled:
          <input name="distance" type="number" value={formValues.distance} onChange={handleChange} />
        </label>
        <input type="submit" value="Submit" />
      </form>
    </div>
  );
}

export default App;
