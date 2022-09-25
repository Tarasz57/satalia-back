import { useEffect, useRef, useState } from "react";
import { calculatePath } from "../requests/PathCalculation";
import { Results } from "./Results";

export const Form = () => {
  const [formValues, setFormValues] = useState({
    latStart: "",
    lonStart: "",
    distanceAvailable: "",
  });
  const [result, setResult] = useState(null);

  const handleSubmit = async (event) => {
    calculatePath(formValues).then((response) => {
      console.log(formValues, response);
      setResult(response);
    });
    event.preventDefault();
  };

  const handleChange = (event) => {
    const target = event.target;
    const name = target.name;
    setFormValues({
      ...formValues,
      [name]: target.value,
    });
  };

  return (
    <>
      <form onSubmit={handleSubmit}>
        <div className="form">
          <div className="title">Welcome</div>
          <div className="subtitle">Let's get some beer! </div>
          <div className="input-container ic1">
            <input
              id="latStart"
              step="any"
              name="latStart"
              className="input"
              type="number"
              placeholder=" "
              onChange={handleChange}
            />
            <div className="cut"></div>
            <label htmlFor="latStart" className="placeholder">
              Latitude
            </label>
          </div>
          <div className="input-container ic2">
            <input
              id="lonStart"
              step="any"
              name="lonStart"
              className="input"
              type="number"
              placeholder=" "
              onChange={handleChange}
            />
            <div className="cut"></div>
            <label htmlFor="lonStart" className="placeholder">
              Longitude
            </label>
          </div>
          <div className="input-container ic2">
            <input
              id="distanceAvailable"
              step="any"
              name="distanceAvailable"
              className="input"
              type="number"
              placeholder=" "
              onChange={handleChange}
            />
            <div className="cut cut-short"></div>
            <label htmlFor="distanceAvailable" className="placeholder">
              Fuel left
            </label>
          </div>
          <button type="text" className="submit">
            Calculate
          </button>
        </div>
      </form>
      {result && <Results path={result}></Results>}
    </>
  );
};
