import { Center, Group, Stack } from "@mantine/core"
import { StatsSegments } from "../components/StatsSegments"
import {UsersTable} from "../components/UsersTable"

export function FinancialRecords() {
    return <Center mt={100} ml={350}><Stack style={{ width: "90vh", height: "90vh" }}>
        <Group grow>
        <StatsSegments name="Savings Goal" amount="$5000 / $10000" percent={50} />
         <StatsSegments name="Budget Goal" amount="2450 / 4000" percent={61} />
         </Group>
         <UsersTable data={[{column1: "Hobbies", column2: "Expenses", name:"Rock Climbing",job:"Expensive",cost:"300$"},{column1: "Hobbies", column2: "Expenses", name:"Skiing",job:"Expensive",cost:"350$"},{column1: "Hobbies", column2: "Expenses", name:"Gaming",job:"Expensive",cost:"200$"}]}></UsersTable>
         <UsersTable data={[{column1: "Needs", column2: "Expenses", name:"Rent",job:"Expensive",cost:"1300$"},{column1: "Needs", column2: "Expenses", name:"Groceries",job:"Expensive",cost:"300$"},{column1: "Needs", column2: "Expenses",name:"Car Insurance",job:"Expensive",cost:"120$"}]}></UsersTable>
         </Stack></Center>
}