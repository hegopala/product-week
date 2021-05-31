import { LinearProgress } from "@material-ui/core"

const Loader: React.FC = () => {
    return (
        <div style={{ height: "4px", width: "100vw", left: "0", top: "0", position: "fixed" }}>
            <LinearProgress />
        </div>
    );
}

export default Loader;