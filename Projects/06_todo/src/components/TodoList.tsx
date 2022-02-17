import { TodoItem } from "./TodoItem";

import { ITodo } from "../types/Data";

interface ITodoListProps {
  item: ITodo[];
  removeTodo: (id: number) => void;
  toggleTodo: (id: number) => void;
}

const TodoList: React.FC<ITodoListProps> = (props) => {
  const { item, removeTodo, toggleTodo } = props;

  return (
    <div>
      {props.item.map((todo) => (
        <TodoItem
          key={todo.id}
          removeTodo={removeTodo}
          toggleTodo={toggleTodo}
          {...todo}
        />
      ))}
    </div>
  );
};

export { TodoList };
