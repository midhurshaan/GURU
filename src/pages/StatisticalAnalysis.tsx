import { Center, Stack } from "@mantine/core"
import {StatsSegments} from "../components/StatsSegments"
import { StatsGrid } from "../components/StatsGrid"

export function StatisticalAnalysis () {
    return (
        <Center ml ={300} style={{width:"90vh", height:"90vh"}}>
    <Stack >
        <StatsSegments name="Monthly Budget" amount="$2450 / $4000" percent={60} />
        <StatsGrid data={[{ title: "Savings this month", icon: "receipt", value: "5000", diff: 5 },{ title: "Expenses for Needs this Month", icon: "receipt", value: "2050", diff: -10 },{ title: "Expenses for hobbies this month", icon: "receipt", value: "400", diff: 15  },{ title: "Total Expenses last month", icon: "receipt", value: "2627", diff: -1.77  }]}/>
        </Stack></Center>)
}