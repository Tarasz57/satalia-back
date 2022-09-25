export const Results = (props) => {
  const { breweriesVisited, beersCollected, distanceTravelled } = props.path;
  const breweriesList = breweriesVisited.map((part) => (
    <li key={crypto.randomUUID()}>{part}</li>
  ));
  const beersList = beersCollected.map((part) => (
    <li key={crypto.randomUUID()}>{part}</li>
  ));
  const divStyles = { marginLeft: "1vw" };
  return (
    <div className="results">
      <div style={divStyles}>
        <label>Breweries visited:</label>
        <ul>{breweriesList}</ul>
      </div>
      <div style={divStyles}>
        <label>Beers collected:</label>
        <ul>{beersList}</ul>
      </div>
      <div style={divStyles}>
        <label>Distance travelled:</label>
        <span style={{ display: "block", marginTop: "2vh" }}>
          {distanceTravelled}
        </span>
      </div>
    </div>
  );
};
