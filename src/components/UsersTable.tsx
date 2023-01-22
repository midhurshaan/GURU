import {
    Avatar,
    Badge,
    Table,
    Group,
    Text,
    ActionIcon,
    Anchor,
    ScrollArea,
    useMantineTheme,
  } from '@mantine/core';
  import { IconPencil, IconTrash } from '@tabler/icons';
  
  interface UsersTableProps {
    data: { name: string; job: string; cost: string; column1: string; column2: string; }[];
  }
  
  const jobColors: Record<string, string> = {
    engineer: 'blue',
    manager: 'cyan',
    designer: 'pink',
  };
  
  export function UsersTable({ data }: UsersTableProps) {
    const theme = useMantineTheme();
    const rows = data.map((item) => (
      <tr key={item.name}>
        <td>
          <Group spacing="sm">
            <Text size="sm" weight={500}>
              {item.name}
            </Text>
          </Group>
        </td>
  
        <td>
          <Text size="sm" color="dimmed">
            {item.cost}
          </Text>
        </td>
        <td>
          <Group spacing={0} position="right">
            <ActionIcon>
              <IconPencil size={16} stroke={1.5} />
            </ActionIcon>
            <ActionIcon color="red">
              <IconTrash size={16} stroke={1.5} />
            </ActionIcon>
          </Group>
        </td>
      </tr>
    ));
  
    return (
      <ScrollArea>
        <Table sx={{ minWidth: 800 }} verticalSpacing="sm">
          <thead>
            <tr>
              <th> {data[0].column1} </th>
              <th> {data[0].column2}</th>
              
            </tr>
          </thead>
          <tbody>{rows}</tbody>
        </Table>
      </ScrollArea>
    );
  }